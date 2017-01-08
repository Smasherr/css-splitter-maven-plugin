package biz.gabrys.maven.plugins.css.splitter.steadystate;

import java.util.List;

import org.apache.maven.plugin.logging.Log;
import org.junit.Assert;
import org.mockito.Mockito;

import biz.gabrys.maven.plugins.css.splitter.css.Standard;
import biz.gabrys.maven.plugins.css.splitter.css.type.NodeRule;
import biz.gabrys.maven.plugins.css.splitter.css.type.StyleProperty;
import biz.gabrys.maven.plugins.css.splitter.css.type.StyleRule;
import biz.gabrys.maven.plugins.css.splitter.css.type.StyleSheet;

final class StarHackTester {

    private final Standard standard;
    private final boolean starHackAllowed;

    public StarHackTester(final Standard standard, final boolean starHackAllowed) {
        this.standard = standard;
        this.starHackAllowed = starHackAllowed;
    }

    public StyleSheet parse() {
        final StringBuilder css = new StringBuilder();
        css.append("div {\n");
        css.append(" width: 0;\n");
        css.append(" *width: 0;\n");
        css.append(" height: 0;\n");
        css.append("}\n");

        final SteadyStateParser parser = new SteadyStateParser(Mockito.mock(Log.class));
        final ParserOptions options = new ParserOptionsBuilder().withStandard(standard).withStarHack(starHackAllowed).create();
        return parser.parse(css.toString(), options);
    }

    public void verify(final StyleSheet stylesheet) {
        Assert.assertNotNull(String.format("StyleSheet instance for standard %s.", standard), stylesheet);
        final List<NodeRule> rules = stylesheet.getRules();
        Assert.assertNotNull(String.format("StyleSheet rules instnace for standard %s.", standard), rules);
        Assert.assertEquals(String.format("StyleSheet children rules for standard %s.", standard), 1, rules.size());
        Assert.assertEquals(String.format("First child class for standard %s.", standard), StyleRule.class, rules.get(0).getClass());

        final StyleRule styleRule = (StyleRule) rules.get(0);
        final List<StyleProperty> properties = styleRule.getProperties();
        Assert.assertEquals(String.format("Properties quantity for standard %s.", standard), 3, properties.size());
        Assert.assertEquals(String.format("First property code for standard %s.", standard), "width: 0;", properties.get(0).getCode());
        Assert.assertEquals(String.format("Second property code for standard %s.", standard), "*width: 0;", properties.get(1).getCode());
        Assert.assertEquals(String.format("Third property code for standard %s.", standard), "height: 0;", properties.get(2).getCode());
    }
}