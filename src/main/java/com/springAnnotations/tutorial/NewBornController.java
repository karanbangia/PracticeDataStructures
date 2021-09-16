//package com.springAnnotations.tutorial;
//
//import com.temp.Elder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class NewBornController {
//    @Value("${number}")
//    private int value;
//
//    @Autowired
//    BabyHealthProvider babyHealthProvider;
//
//    @Autowired
//    Elder elder;
//
//    @GetMapping("/baby")
//    public String getBaby()
//    {
//        return "Baby Name"+value;
//    }
//
//    @GetMapping("/baby")
//    public String getElder()
//    {
//        elder.elderOne();
//        return "";
//    }
//}
