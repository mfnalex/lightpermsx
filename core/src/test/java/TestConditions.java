import com.jeff_media.lightpermsx.permission.condition.ConditionFactory;
import com.jeff_media.lightpermsx.permission.condition.SimpleStringCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConditions {

    @Test
    public void testSimpleStringCondition() {
        SimpleStringCondition condition = new SimpleStringCondition("key", "value", false);
        Assertions.assertTrue(condition.isSatisified("value"));
        Assertions.assertFalse(condition.isSatisified("notvalue"));

        SimpleStringCondition negatedCondition = new SimpleStringCondition("key", "value", true);
        Assertions.assertFalse(negatedCondition.isSatisified("value"));
        Assertions.assertTrue(negatedCondition.isSatisified("notvalue"));
    }
}
