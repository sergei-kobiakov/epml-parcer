import org.parboiled.BaseParser;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;

@BuildParseTree
class Epml extends BaseParser<Object> {

    Rule empl() {
        return Sequence(metadata(), article());
    }

    Rule metadata() {
        return OneOrMore(TestNot("_PI_"), ANY);
    }

    Rule article() {
        return OneOrMore(paragraph());
    }

    Rule paragraph() {
        return Sequence(paragraphTag(), text());
    }

    Rule paragraphTag() {
        return String("_PI_");
    }

    Rule text() {
        return Sequence(simpleText(), boldText(), Optional(Sequence(Test(ANY), text())));
    }

     Rule boldText() {
        return Optional(Sequence("_B_", OneOrMore(TestNot("_b_"), ANY), "_b_"));
    }

    Rule simpleText() {
        return ZeroOrMore(TestNot("_B_"), ANY);
    }
}

