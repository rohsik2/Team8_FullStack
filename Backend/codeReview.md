# 코드리뷰어들을 위한 코드에 대한 설명들

코드리뷰를 받고 싶은 파트는 exam과 관련된 api와 파트들입니다.
exam은 기본적으로 5가지 종류로 이루어져있습니다.
none - purchased - submitted - passed - failed

모든 시험은 한번의 구매 이후에 PURCHASED상태로 바뀌게 됩니다.

사용자 시나리오는 다음과 같습니다.
구매 -> 시험응시 -> 합격 또는 불합격

이때 시험은 2가지 종류가 존재합니다. 

Multiple Choice Question -> 특정 점수를 넘기면 합격입니다.

Free Response Question -> 줄글로 된 과제와 실제 해당 과제를 수행한 URL 링크를 넣습니다.

해당 기능들을 구현하기 위해서 구현된 API는 다음과 같습니다. 

Description       | API endpoint | GET | POST | PUT | DELETE
-- | -- | -- | -- | -- | --
Exam Detail       | /api/exam/{:examId} | O |   |   |
Assignment Submit | /api/exam/assignment |  | O |  |
Assignment Detail | /api/exam/assignment/{:examSubmissionId} | O | | |
Exam Purchase Success    | /api/purchase/exam/success | O |  |   |
Exam Purchase Fail    | /api/purchase/exam/fail | O |  |   |
Exam Result       | /api/exam/result |  |   | O |
Peer Review Detail| /api/exam/peer/{:examId} | O | | |
Do AI Code Review | /api/exam/ai/{:examSubmissionId} | | O | |
AI Review Fin     | /api/exam/ai/{:examSubmissionId} | O | | |

- Exam Detail : 시험에 대한 정보를 리턴합니다. 시험의 재목, 문제등을 가지고 있습니다.
- Assignment Submit : 시험의 결과를 제출합니다. 
  - 시험구매여부를 확인하고
  - 시험을 제출합니다.
- Assignment Detail : 시험 제출물을 가져옵니다.
- Exam Purchase Success : 시험 구매에 성공했을 경우 해당 api로 get요청이 날아옵니다.
  - tossUtlity 를 이용해 구매정보에 대해 validation check을 진행하고
  - examService를 이용해 orderID로 부터 알아낸 시험정보를 구매합니다.
  - 이후 요청을 리다이렉트 시켜 프론트로 보냅니다.
- Exam Purchase Failed : 구매에 실패했으므로 홈페이지로 보냅니다.
- Exam Result : 객관식 시험의 합격 여부를 프론트로부터 받아서 저장합니다.
- Peer Review Detail : 구현은 되어있지만 사용하지 않습니다.
- Do AI Code Review : 깃허브로 부터 코드를 긁어와 파일별로 open AI에게 코드리뷰를 부탁합니다.
  - exam 제출물을 가져와 새로운 thread를 통해 코드를 가져와 리뷰를 이슈에 달도록 시킵니다.
  - 이후 바로 OK를 리턴합니다.
- isAIReviewFinish : ai 리뷰가 끝나면 해당 method는 ok를 리턴합니다. 
  - 하나의 요청이 지나치게 오랫동안 대기하는 것을 방지하기위해서 사용합니다.
  - 클라이언트는 코드리뷰 요청을 보내고 나서, 코드리뷰가 끝났는지 이 api를 통해서 완료 여부를 확인합니다.



# 실제 코드들
https://github.com/softeerbootcamp/Team8_FullStack/tree/dev/Backend/src/main/java/site/devroad/softeer/src/exam


# 리뷰 해주십사 하는 파트들

1. jpa와 같은 orm기술이 아니라 모든 정보를 sql을 직접 쏘는 방식으로 해결하고 있습니다. 혹시 jpa를 통해서 최적화 하면 어떤식으로 찾아보아야할지 궁급합니다.
2. 처음 코드를 보시더라도 해당 메소드들이 대략 어떤일 을 하는지 이해가 되는지 궁금합니다. 읽으면서 이러한 파트가 readme에 있으면 좋겠다 하는게 있으면 알려주시면 좋을 것 같습니다.
3. service, repository dto 등등의 단어들을 잘 사용했는지 모르겠습니다. dto내부에 여러 객체들을 하나씩 api마다 만들고 있는데 폴더를 더 나누면 좋을지 고민입니다.
