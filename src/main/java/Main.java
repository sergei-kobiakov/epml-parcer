import org.parboiled.Parboiled;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

public class Main {


    public static void main(String[] args) {
        String input = "metadata" +
                "_PI_not bold1_B_bold_b_not bold1_B_bold2_b_fdfdfdfdfdfdfd" +
                "_PI_not bold3_B_bold_b_not bold3_B_bold4_b_fdfdfdfdfdfdfd";
        Epml parser = Parboiled.createParser(Epml.class);
        ParsingResult<?> result = new ReportingParseRunner(parser.empl()).run(input);


        String parseTreePrintOut = ParseTreeUtils.printNodeTree(result);
        System.out.println(parseTreePrintOut);
    }
}