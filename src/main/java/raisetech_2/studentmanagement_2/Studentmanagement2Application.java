package raisetech_2.studentmanagement_2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Studentmanagement2Application {

  // 1つの学生情報（シンプルなパターン）
  private String name = "Enami Kouji";
  private String age = "37";

  // 複数の学生情報（Mapを使ったパターン）
  private Map<String, String> student = new ConcurrentHashMap<>();

  public static void main(String[] args) {
    SpringApplication.run(Studentmanagement2Application.class, args);
  }

  // シンプルな学生情報を取得するエンドポイント
  @GetMapping("/studentInfo")
  public String getStudentInfo() {
    return name + " " + age + "歳";
  }

  // シンプルな学生情報を更新するエンドポイント
  @PostMapping("/studentInfo")
  public String setStudentInfo(@RequestParam String name, @RequestParam String age) {
    this.name = name;
    this.age = age;
    return "学生情報が更新されました：" + name + " " + age + "歳";
  }

  // 名前のみ更新するエンドポイント
  @PostMapping("/studentName")
  public String updateStudentName(@RequestParam String name) {
    this.name = name;
    return "学生の名前が更新されました：" + name;
  }

  // Mapを使った複数の学生情報を取得するエンドポイント
  @GetMapping("/studentInfo2")
  public Map<String, String> getStudentMap() {
    return student;
  }

  // Mapを使って学生情報を追加するエンドポイント
  @PostMapping("/studentInfo2/add")
  public String addStudentToMap(@RequestParam String name, @RequestParam String age) {
    student.put(name, age + "歳");
    return "学生情報が追加されました：" + name + " " + age + "歳";
  }
}
