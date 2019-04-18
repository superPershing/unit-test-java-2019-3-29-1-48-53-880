package tw.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test(expected = Test.None.class)
    public void should_pass_validate_when_answer_format_is_right() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 3 4");
        answer.validate();
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void should_fail_validate_when_answer_format_if_wrong() throws OutOfRangeAnswerException {
        expectedException.expect(OutOfRangeAnswerException.class);
        Answer.createAnswer("1 2 3 3").validate();
        Answer.createAnswer("1 2 3").validate();
        Answer.createAnswer("1 2 3 4 5").validate();
    }

    @Test
    public void test_answer_check() {
        Answer standardAnswer = Answer.createAnswer("1 2 3 4");
        Answer answerToBeCheck1 = Answer.createAnswer("1 2 3 4");
        Answer answerToBeCheck2 = Answer.createAnswer("2 3 4 1");
        Answer answerToBeCheck3 = Answer.createAnswer("1 3 4 6");
        Answer answerToBeCheck4 = Answer.createAnswer("9 8 7 6");

        assertEquals(standardAnswer.check(answerToBeCheck1).getValue(), "4A0B");
        assertEquals(standardAnswer.check(answerToBeCheck2).getValue(), "0A4B");
        assertEquals(standardAnswer.check(answerToBeCheck3).getValue(), "1A2B");
        assertEquals(standardAnswer.check(answerToBeCheck4).getValue(), "0A0B");
    }
}