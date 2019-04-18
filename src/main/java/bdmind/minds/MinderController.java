package bdmind.minds;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bdmind.beans.Minds;
import bdmind.minds.service.MindService;

@RestController
@CrossOrigin
public class MinderController {
	@Autowired
	MindService ms;
		
	@RequestMapping("/mind/{name}")
	@ResponseBody
	String fetch(@PathVariable String name) {
		Minds mind = ms.fetchMind(name);
		if(null != mind) 
			return mind.getXmind();
		else 
			return "None";
	}
	 
	@RequestMapping(value = "/mindsv/{name}", method = RequestMethod.POST)
	@ResponseBody
	String save(@PathVariable String name, String mindBody) {
		Minds mind = new Minds();
		mind.setName(name);
		mind.setXmind(mindBody);
		ms.saveMind(mind);
		return name;
	}
	
	@RequestMapping("/mindlist")
	@ResponseBody
	List<Minds> fetchlist(){
		return ms.fetchList();
	}
	
}
