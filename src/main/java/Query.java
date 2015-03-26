import java.util.Arrays;

/**
* Created by joel on 3/18/15.
*/
public class Query {
  private String[] args;
  private String opr;

  public String[] getArgs() {
    return args;
  }

  public String getOpr() {
    return opr;
  }

  public Query(String userInput) {
    opr = "";
    args = new String[]{};

    String[] tokens = userInput.split(" ");
    if (tokens.length > 0) {
      opr = tokens[0];
    }
    if (tokens.length > 1) {
      args = Arrays.copyOfRange(tokens, 1, tokens.length);
    }
  }
}
