package tr.com.isdemir.egitim.controller.ornek;


import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tr.com.isdemir.egitim.entity.Dept;

@CrossOrigin
@RestController
@RequestMapping("/ornek")
public class OrnekController {
	
    @GetMapping("/hello")
    public Collection<String> sayHello() {
        return IntStream.range(0, 10)
          .mapToObj(i -> "Hello number " + i)
          .collect(Collectors.toList());
    }
    
    @GetMapping("/hello1")
    public String sayHello1() {
        return "merhaba1";
    }
    
    @GetMapping(value= "/hello2", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String sayHello2() {    	
        return "merhaba";
    }
    
    @GetMapping(value= "/hello3",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Dept sayHello3() {
    	Dept d = new Dept();
    	d.setDeptno(1L);
    	d.setDname("Muhasebe");
        return d;
    }
    
   
}
