import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

@BuildParseTree
class CalculatorParser extends BaseParser<Object> {

    Rule empl() {
        return Sequence(metadata(), article());
    }

    Rule metadata() {
        return OneOrMore(TestNot("_PI_"), ANY);
    }

    Rule article() {
        return OneOrMore(paragraph());
    }

    Rule  paragraph(){
        return Sequence(paragraphTag(), paragraphContent());
    }

    Rule paragraphTag(){
     return String("_PI_");
    }

    Rule paragraphContent() {
        return ZeroOrMore(TestNot("_PI_"), ANY);
    }
}

