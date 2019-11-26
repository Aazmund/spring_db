import com.example.database.Repo;
import com.example.database.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SomethingController {
    @Autowired
    private Repo repo;

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Something> somethings = repo.findAll();
        model.put("something", somethings);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam Integer count, @RequestParam Float coast, Map<String, Object> model){
        Something something= new Something(name, count, coast);
        repo.save(something);
        Iterable<Something> somethings = repo.findAll();
        model.put("something", somethings);
        return "main";
    }

}
