package biz.gabrys.maven.plugins.css.splitter.tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public final class OrderedTreeTest {

    @Test
    public void create_zeroObjects() {
        final OrderedTree<Object> tree = new OrderedTree<Object>(Collections.emptyList(), 2);

        Assert.assertFalse("Root should not contain value.", tree.hasValue());
        Assert.assertNull("Root value should be equal to null.", tree.getValue());
        Assert.assertEquals("Root children size.", 0, tree.getChildren().size());
        Assert.assertEquals("Root tree size.", 0, tree.size());
        Assert.assertEquals("Root order.", 0, tree.getOrder());
    }

    @Test
    public void create_threeObjects_numberOfChildrenEqualToFive() {
        final Object obj1 = Mockito.mock(Object.class);
        final Object obj2 = Mockito.mock(Object.class);
        final Object obj3 = Mockito.mock(Object.class);

        final OrderedTree<Object> tree = new OrderedTree<Object>(Arrays.asList(obj1, obj2, obj3), 5);

        Assert.assertFalse("Root should not contain value.", tree.hasValue());
        Assert.assertNull("Root value should be equal to null.", tree.getValue());
        final List<OrderedTreeNode<Object>> children = tree.getChildren();
        Assert.assertEquals("Root children size.", 3, children.size());
        Assert.assertEquals("Root tree size.", 3, tree.size());
        Assert.assertEquals("Root order.", 0, tree.getOrder());

        final OrderedTreeNode<Object> child1 = children.get(0);
        Assert.assertTrue("First child should contain value.", child1.hasValue());
        Assert.assertEquals("First child value should be equal to obj1.", obj1, child1.getValue());
        Assert.assertEquals("First child children size.", 0, child1.getChildren().size());
        Assert.assertEquals("First child tree size.", 1, child1.size());
        Assert.assertEquals("First child order.", 1, child1.getOrder());

        final OrderedTreeNode<Object> child2 = children.get(1);
        Assert.assertTrue("Second child should contain value.", child2.hasValue());
        Assert.assertEquals("Second child value should be equal to obj2.", obj2, child2.getValue());
        Assert.assertEquals("Second child children size.", 0, child2.getChildren().size());
        Assert.assertEquals("Second child tree size.", 1, child2.size());
        Assert.assertEquals("Second child order.", 2, child2.getOrder());

        final OrderedTreeNode<Object> child3 = children.get(2);
        Assert.assertTrue("Third child should contain value.", child3.hasValue());
        Assert.assertEquals("Third child value should be equal to obj3.", obj3, child3.getValue());
        Assert.assertEquals("Third child children size.", 0, child3.getChildren().size());
        Assert.assertEquals("Third child tree size.", 1, child3.size());
        Assert.assertEquals("Third child order.", 3, child3.getOrder());
    }

    @Test
    public void create_fiveObjects_numberOfChildrenEqualToTwo() {
        final Object obj1 = Mockito.mock(Object.class);
        final Object obj2 = Mockito.mock(Object.class);
        final Object obj3 = Mockito.mock(Object.class);
        final Object obj4 = Mockito.mock(Object.class);
        final Object obj5 = Mockito.mock(Object.class);

        final OrderedTree<Object> tree = new OrderedTree<Object>(Arrays.asList(obj1, obj2, obj3, obj4, obj5), 2);

        Assert.assertFalse("Root should not contain value.", tree.hasValue());
        Assert.assertNull("Root value should be equal to null.", tree.getValue());
        final List<OrderedTreeNode<Object>> rootChildren = tree.getChildren();
        Assert.assertEquals("Root children size.", 2, rootChildren.size());
        Assert.assertEquals("Root tree size.", 8, tree.size());
        Assert.assertEquals("Root order.", 0, tree.getOrder());

        final OrderedTreeNode<Object> rootChild1 = rootChildren.get(0);
        Assert.assertFalse("Root first child should not contain value.", rootChild1.hasValue());
        Assert.assertNull("Root first child value should be equal to null.", rootChild1.getValue());
        final List<OrderedTreeNode<Object>> rootChild1Children = rootChild1.getChildren();
        Assert.assertEquals("Root first child children size.", 2, rootChild1Children.size());
        Assert.assertEquals("Root first child tree size.", 4, rootChild1.size());
        Assert.assertEquals("Root first child order.", 1, rootChild1.getOrder());

        final OrderedTreeNode<Object> rootChild1Child1 = rootChild1Children.get(0);
        Assert.assertFalse("Root first child first child should not contain value.", rootChild1Child1.hasValue());
        Assert.assertNull("Root first child first child value should be equal to null.", rootChild1Child1.getValue());
        final List<OrderedTreeNode<Object>> rootChild1Child1Children = rootChild1Child1.getChildren();
        Assert.assertEquals("Root first child first child children size.", 2, rootChild1Child1Children.size());
        Assert.assertEquals("Root first child first child tree size.", 2, rootChild1Child1.size());
        Assert.assertEquals("Root first child first child order.", 2, rootChild1Child1.getOrder());
        final OrderedTreeNode<Object> rootChild1Child1Child1 = rootChild1Child1Children.get(0);
        Assert.assertTrue("Root first child first child first child should not contain value.", rootChild1Child1Child1.hasValue());
        Assert.assertEquals("Root first child first child first child value should be equal to obj1.", obj1,
                rootChild1Child1Child1.getValue());
        Assert.assertEquals("Root first child first child first child children size.", 0, rootChild1Child1Child1.getChildren().size());
        Assert.assertEquals("Root first child first child first child tree size.", 1, rootChild1Child1Child1.size());
        Assert.assertEquals("Root first child first child first child order.", 3, rootChild1Child1Child1.getOrder());
        final OrderedTreeNode<Object> rootChild1Child1Child2 = rootChild1Child1Children.get(1);
        Assert.assertTrue("Root first child first child second child should not contain value.", rootChild1Child1Child2.hasValue());
        Assert.assertEquals("Root first child first child second child value should be equal to obj2.", obj2,
                rootChild1Child1Child2.getValue());
        Assert.assertEquals("Root first child first child second child children size.", 0, rootChild1Child1Child2.getChildren().size());
        Assert.assertEquals("Root first child first child second child tree size.", 1, rootChild1Child1Child2.size());
        Assert.assertEquals("Root first child first child second child order.", 4, rootChild1Child1Child2.getOrder());

        final OrderedTreeNode<Object> rootChild1Child2 = rootChild1Children.get(1);
        Assert.assertTrue("Root first child second child should contain value.", rootChild1Child2.hasValue());
        Assert.assertEquals("Root first child second child value should be equal to obj3.", obj3, rootChild1Child2.getValue());
        Assert.assertEquals("Root first child second child children size.", 0, rootChild1Child2.getChildren().size());
        Assert.assertEquals("Root first child second child tree size.", 1, rootChild1Child2.size());
        Assert.assertEquals("Root first child second child order.", 5, rootChild1Child2.getOrder());

        final OrderedTreeNode<Object> rootChild2 = rootChildren.get(1);
        Assert.assertFalse("Root second child should not contain value.", rootChild2.hasValue());
        Assert.assertNull("Root second child value should be equal to null.", rootChild2.getValue());
        final List<OrderedTreeNode<Object>> rootChild2Children = rootChild2.getChildren();
        Assert.assertEquals("Root second child children size.", 2, rootChild2Children.size());
        Assert.assertEquals("Root second child tree size.", 2, rootChild2.size());
        Assert.assertEquals("Root second child order.", 6, rootChild2.getOrder());
        final OrderedTreeNode<Object> rootChild2Child1 = rootChild2Children.get(0);
        Assert.assertTrue("Root second child first child should contain value.", rootChild2Child1.hasValue());
        Assert.assertEquals("Root second child first child value should be equal to obj4.", obj4, rootChild2Child1.getValue());
        Assert.assertEquals("Root second child first child children size.", 0, rootChild2Child1.getChildren().size());
        Assert.assertEquals("Root second child first child tree size.", 1, rootChild2Child1.size());
        Assert.assertEquals("Root second child first child order.", 7, rootChild2Child1.getOrder());
        final OrderedTreeNode<Object> rootChild2Child2 = rootChild2Children.get(1);
        Assert.assertTrue("Root second child second child should contain value.", rootChild2Child2.hasValue());
        Assert.assertEquals("Root second child second child value should be equal to obj5.", obj5, rootChild2Child2.getValue());
        Assert.assertEquals("Root second child second child children size.", 0, rootChild2Child2.getChildren().size());
        Assert.assertEquals("Root second child second child tree size.", 1, rootChild2Child2.size());
        Assert.assertEquals("Root second child second child order.", 8, rootChild2Child2.getOrder());
    }

    @Test
    public void create_fourObjects_numberOfChildrenEqualToThree() {
        final Object obj1 = Mockito.mock(Object.class);
        final Object obj2 = Mockito.mock(Object.class);
        final Object obj3 = Mockito.mock(Object.class);
        final Object obj4 = Mockito.mock(Object.class);

        final OrderedTree<Object> tree = new OrderedTree<Object>(Arrays.asList(obj1, obj2, obj3, obj4), 3);

        Assert.assertFalse("Root should not contain value.", tree.hasValue());
        Assert.assertNull("Root value should be equal to null.", tree.getValue());
        final List<OrderedTreeNode<Object>> rootChildren = tree.getChildren();
        Assert.assertEquals("Root children size.", 3, rootChildren.size());
        Assert.assertEquals("Root tree size.", 5, tree.size());
        Assert.assertEquals("Root order.", 0, tree.getOrder());

        final OrderedTreeNode<Object> rootChild1 = rootChildren.get(0);
        Assert.assertFalse("Root first child should not contain value.", rootChild1.hasValue());
        Assert.assertNull("Root first child value should be equal to null.", rootChild1.getValue());
        final List<OrderedTreeNode<Object>> rootChild1Children = rootChild1.getChildren();
        Assert.assertEquals("Root first child children size.", 2, rootChild1Children.size());
        Assert.assertEquals("Root first child tree size.", 2, rootChild1.size());
        Assert.assertEquals("Root first child order.", 1, rootChild1.getOrder());

        final OrderedTreeNode<Object> rootChild1Child1 = rootChild1Children.get(0);
        Assert.assertTrue("Root first child first child should contain value.", rootChild1Child1.hasValue());
        Assert.assertEquals("Root first child first child value should be equal to obj1.", obj1, rootChild1Child1.getValue());
        Assert.assertEquals("Root first child first child children size.", 0, rootChild1Child1.getChildren().size());
        Assert.assertEquals("Root first child first child tree size.", 1, rootChild1Child1.size());
        Assert.assertEquals("Root first child first child order.", 2, rootChild1Child1.getOrder());
        final OrderedTreeNode<Object> rootChild1Child2 = rootChild1Children.get(1);
        Assert.assertTrue("Root first child second child should contain value.", rootChild1Child2.hasValue());
        Assert.assertEquals("Root first child second child value should be equal to obj2.", obj2, rootChild1Child2.getValue());
        Assert.assertEquals("Root first child second child children size.", 0, rootChild1Child2.getChildren().size());
        Assert.assertEquals("Root first child second child tree size.", 1, rootChild1Child2.size());
        Assert.assertEquals("Root first child second child order.", 3, rootChild1Child2.getOrder());

        final OrderedTreeNode<Object> rootChild2 = rootChildren.get(1);
        Assert.assertTrue("Root second child should contain value.", rootChild2.hasValue());
        Assert.assertEquals("Root second child value should be equal to obj3.", obj3, rootChild2.getValue());
        Assert.assertEquals("Root second child children size.", 0, rootChild2.getChildren().size());
        Assert.assertEquals("Root second child tree size.", 1, rootChild2.size());
        Assert.assertEquals("Root second child order.", 4, rootChild2.getOrder());

        final OrderedTreeNode<Object> rootChild3 = rootChildren.get(2);
        Assert.assertTrue("Root third child should contain value.", rootChild3.hasValue());
        Assert.assertEquals("Root third child value should be equal to obj4.", obj4, rootChild3.getValue());
        Assert.assertEquals("Root third child children size.", 0, rootChild3.getChildren().size());
        Assert.assertEquals("Root third child tree size.", 1, rootChild3.size());
        Assert.assertEquals("Root third child order.", 5, rootChild3.getOrder());
    }
}
