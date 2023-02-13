package site.devroad.softeer.src.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import site.devroad.softeer.exceptions.CustomException;
import site.devroad.softeer.src.roadmap.subject.Subject;
import site.devroad.softeer.src.roadmap.subject.SubjectRepo;
import site.devroad.softeer.src.exam.ExamService;
import site.devroad.softeer.src.exam.ExamSubmissionRepo;
import site.devroad.softeer.src.exam.dto.PostAssignSubmitReq;
import site.devroad.softeer.src.user.UserRepo;
import site.devroad.softeer.src.user.model.Account;
import site.devroad.softeer.src.user.model.LoginInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class ExamServiceTest {

    @Autowired
    ExamService examService;
    @Autowired
    UserRepo userRepo;

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    ExamSubmissionRepo submissionRepo;


    @Test
    @DisplayName("사용자가 실제로 해당 테스트를 패스 했는지 성공여부를 확인.")
    void checkIfExamPassed() {
        //given
        LoginInfo loginInfo = userRepo.findByEmail("jm1234@naver.com").get();
        Account account = userRepo.findAccountById(loginInfo.getAccountId());

        Subject subject = subjectRepo.findById(1L).get();
        //when
        try {
            Boolean result = examService.isUserPassedExam(subject.getId(), account.getId());

            //then
            assertEquals(result, true);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
