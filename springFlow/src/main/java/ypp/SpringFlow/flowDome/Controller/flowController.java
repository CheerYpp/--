package ypp.SpringFlow.flowDome.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

//@Controller
public class flowController {

    @GetMapping("/shopping")
    public String test(){
        return "flowExecutor";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line=scanner.nextLine();
        System.out.println(line);
        new ArrayList<>().stream().collect(Collectors.toList());
    }
}
