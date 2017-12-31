package xyz.theone.springbootlearning.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.theone.springbootlearning.helloworld.model.HelloWorld;

/**
 * 描述:
 * Hello world接口
 *
 * @outhor winson
 * @create 2017-12-31 12:12
 */
@RestController
public class HelloWorldController {

    @RequestMapping(value = "/hello")
    public HelloWorld sayHelloToWorld(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setCode(200);
        helloWorld.setMessage("Hello World");
        return helloWorld;
    }
}
