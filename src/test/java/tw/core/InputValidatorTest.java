package tw.core;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.validator.InputValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator inputValidator;

    @Before
    public void setUp() throws Exception {
        inputValidator = new InputValidator();
    }

    @Test
    public void should_get_true_when_validate_right_number_string() {
        assertTrue(inputValidator.validate("1 2 3 4"));
        assertTrue(inputValidator.validate("9 8 7 6"));
    }

    @Test
    public void should_get_false_when_validate_wrong_length_number_string() {
        assertFalse(inputValidator.validate("1 2 3"));
        assertFalse(inputValidator.validate("1 2 3 4 5"));
    }

    @Test
    public void should_get_false_when_validate_duplicate_number_string() {
        assertFalse(inputValidator.validate("1 2 3 3"));
    }

    @Test
    public void should_get_false_when_validate_out_of_range_number_string() {
        assertFalse(inputValidator.validate("10 2 3 4"));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_get_false_when_validate_wrong_format_number_string() {
        thrown.expect(NumberFormatException.class);
        inputValidator.validate("1 2 3 F");
    }
}
