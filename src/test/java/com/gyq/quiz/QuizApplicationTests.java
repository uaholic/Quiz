package com.gyq.quiz;

import com.gyq.quiz.domin.Uanswer;
import com.gyq.quiz.mapper.UanswerMapper;
import com.gyq.quiz.util.DecodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuizApplicationTests {
	@Autowired
	UanswerMapper uamapper;
	@Test
//	public void contextLoads() {
////		Map<Integer, Integer> answerStudent = uamapper.findAnswerStudent(7);
//
//	}
	public void test(){
	System.out.println(DecodeUtil.getMD5("123456"));
	System.out.println(DecodeUtil.getMD5(DecodeUtil.getMD5("123456")));
	System.out.println(DecodeUtil.getMD5(DecodeUtil.getMD5(DecodeUtil.getMD5("123456"))));
	}

}
