package fruit;

import com.google.gson.Gson;
import cucumber.api.java.en.Given;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FruitSteps {

  @Given("^the system knows about the following fruit:$")
  public void theSystemKnowsAboutTheFollowingFruit(List<Fruit> fruitList)
      throws Throwable {
    Gson gson = new Gson();
    PrintWriter writer = new PrintWriter("fruit.json", "UTF-8");
    writer.println(gson.toJson(fruitList));
    writer.close();
  }

}
