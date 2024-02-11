package com.projectlonrocketseat.certificationnlw.models.students.usecase;

import com.projectlonrocketseat.certificationnlw.models.questions.entities.QuestionEntity;
import com.projectlonrocketseat.certificationnlw.models.questions.repositories.QuestionRespository;
import com.projectlonrocketseat.certificationnlw.models.students.dto.CertificationVerifyDTO;
import com.projectlonrocketseat.certificationnlw.models.students.dto.StudentCertificationAnswerDTO;
import com.projectlonrocketseat.certificationnlw.models.students.entities.AnswersCertificationEntity;
import com.projectlonrocketseat.certificationnlw.models.students.entities.CertificationEstudentEntity;
import com.projectlonrocketseat.certificationnlw.models.students.entities.StudentEntity;
import com.projectlonrocketseat.certificationnlw.models.students.repositories.CertificationEstudentRespositories;
import com.projectlonrocketseat.certificationnlw.models.students.repositories.StudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnswersUseCase {

    @Autowired
    private StudentRepositories studentRepository;

    @Autowired
    private QuestionRespository questionRespository;

    @Autowired
    private CertificationEstudentRespositories certificationEstudentRespositories;

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;


    public CertificationEstudentEntity execute(StudentCertificationAnswerDTO dto) throws Exception{

        var hasCertification = this.verifyIfHasCertificationUseCase.execute(new CertificationVerifyDTO(dto.getEmail(), dto.getTechnology()));

        if(hasCertification){
            throw new Exception("Certificação já emitida.");
        }

        // Get alternatives from questions
        // - If is correct or incorrect
        List<QuestionEntity> questionsEntity = questionRespository.findByTechnology(dto.getTechnology());
        List<AnswersCertificationEntity> answersCertification = new ArrayList<>();

        AtomicInteger correctAnswers = new AtomicInteger(0);

        dto.getQuestionsAnswers()
                .stream().forEach(questionAnswer -> {
            var question = questionsEntity.stream()
                    .filter(q -> q.getId().equals(questionAnswer.getQuestionID()));

            var findCorrectAlternative = question.findFirst().get().getAlternatives().stream()
                    .filter(alternative -> alternative.isCorrect()).findFirst().get();

            if(findCorrectAlternative.getId().equals(questionAnswer.getAlternativeID()) ){
                questionAnswer.setCorrect(true);
                correctAnswers.incrementAndGet();
            }else{
                questionAnswer.setCorrect(false);
            }

            var answersCertificationEntity = AnswersCertificationEntity.builder()
                            .answerID(questionAnswer.getAlternativeID())
                                    .questionID(questionAnswer.getQuestionID())
                                            .isCorrect(questionAnswer.isCorrect()).build();

            answersCertification.add(answersCertificationEntity);
        });

        // Verify if user exist
        var student = studentRepository.findByEmail(dto.getEmail());
        UUID studentID;

        if(student.isEmpty()){
            var studentCreated = StudentEntity.builder().email(dto.getEmail()).build();
            studentCreated = studentRepository.save(studentCreated);
            studentID = studentCreated.getId();
        }else{
            studentID = student.get().getId();
        }

        CertificationEstudentEntity certificationEstudentEntity = CertificationEstudentEntity.builder()
                .technology(dto.getTechnology())
                .studentID(studentID)
                .grade(correctAnswers.get())
                .build();

        var certificationStudentCreated = certificationEstudentRespositories.save(certificationEstudentEntity);

        answersCertification.stream().forEach(answerCertificaty -> {
            answerCertificaty.setCertificationID(certificationEstudentEntity.getId());
            answerCertificaty.setCertificationEstudentEntity(certificationEstudentEntity);
        });

        certificationEstudentEntity.setAnswersCertificationEntities(answersCertification);
        certificationEstudentRespositories.save(certificationEstudentEntity);


        return certificationStudentCreated;

        // Save certification information

    }
}
