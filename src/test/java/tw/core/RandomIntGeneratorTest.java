package tw.core;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.generator.RandomIntGenerator;

import static org.junit.Assert.assertEquals;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    RandomIntGenerator randomIntGenerator;

    @Before
    public void setUp() throws Exception {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test
    public void should_generate_nums_string_with_right_digitmax_and_numbersOfNeed() {
        assertEquals(randomIntGenerator.generateNums(10, 4).split(" ").length, 4);
        assertEquals(randomIntGenerator.generateNums(10, 6).split(" ").length, 6);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_raise_IllegalArgumentException_when_input_wrong_digitmax_and_numbersOfNeed() {
        expectedException.expect(IllegalArgumentException.class);
        randomIntGenerator.generateNums(1, 4);
    }
}