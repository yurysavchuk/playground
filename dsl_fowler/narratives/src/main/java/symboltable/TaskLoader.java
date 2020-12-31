package symboltable;

import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.HashMap;

public class TaskLoader {
  private Reader input;
  private Map<String, Task> tasks = new HashMap<String, Task>();

  public TaskLoader(Reader input) {
    this.input = input;
  }

  public void run() {
    try {
      TasksLexer lexer = new TasksLexer(new ANTLRReaderStream(input));
      TaskParser parser = new TaskParser(new CommonTokenStream(lexer));
      parser.helper = this;
      parser.network();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } catch (RecognitionException e) {
      throw new RuntimeException(e);
    }
  }
}
