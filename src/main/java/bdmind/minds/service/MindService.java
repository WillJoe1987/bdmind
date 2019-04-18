package bdmind.minds.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bdmind.beans.Minds;

@Service
@Transactional
public class MindService {

	@PersistenceContext
	private EntityManager em;
	
	public Minds fetchMind(String name){
		Query query =  em.createQuery("select t from Minds t where t.name=:name");
		query.setParameter("name", name);
		if(query.getResultList().size()>0){
			Minds mind = (Minds)query.getSingleResult();
			return mind;
		}else return null;
	}

	public void saveMind(Minds mind){	
		Minds m = this.fetchMind(mind.getName());
		if(null==m){
			mind.setUpdate_date(new Date());
			em.persist(mind);
		}else{
			m.setXmind(mind.getXmind());
			m.setUpdate_date(new Date());
			em.merge(m);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Minds> fetchList(){
		Query query = em.createQuery("select t from Minds t");
		List<Minds> results = (List<Minds>)query.getResultList();
		return results;
	}
	
}