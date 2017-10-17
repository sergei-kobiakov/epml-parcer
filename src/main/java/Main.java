import org.parboiled.Parboiled;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

public class Main {


    public static void main(String[] args) {
        String input = "metadata" +
                "_PI_P1\n" +
                "_PI_P2\n" +
                "_PI_P2\n";
        CalculatorParser parser = Parboiled.createParser(CalculatorParser.class);
        ParsingResult<?> result = new ReportingParseRunner(parser.empl()).run(input);


        String parseTreePrintOut = ParseTreeUtils.printNodeTree(result);
        System.out.println(parseTreePrintOut);
    }
}