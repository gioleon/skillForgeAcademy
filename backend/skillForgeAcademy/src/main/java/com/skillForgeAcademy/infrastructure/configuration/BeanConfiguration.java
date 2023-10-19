package com.skillForgeAcademy.infrastructure.configuration;

import com.skillForgeAcademy.domain.api.*;
import com.skillForgeAcademy.domain.spi.broker.IEmailSenderPort;
import com.skillForgeAcademy.domain.spi.passwordencoder.IPasswordEncoderPort;
import com.skillForgeAcademy.domain.spi.persistence.*;
import com.skillForgeAcademy.domain.usecase.*;
import com.skillForgeAcademy.infrastructure.output.broker.adapter.EmailSenderAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.*;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.*;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.*;
import com.skillForgeAcademy.infrastructure.output.passwordencoder.PasswordEncoderAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

  private final IUserRepository userRepository;
  private final IUserEntityMapper userEntityMapper;
  private final IRolRepository rolRepository;
  private final IRolEntityMapper rolEntityMapper;
  private final ITokenActivationRepository tokenRepository;
  private final ITokenEntityMapper tokenEntityMapper;
  private final ICategoryRepository categoryRepository;
  private final ICategoryEntityMapper categoryEntityMapper;
  private final ICommentRepository commentRepository;
  private final ICommentEntityMapper commentEntityMapper;
  private final ICommentEntityIdMapper commentEntityIdMapper;
  private final IRateRepository rateRepository;
  private final IRateEntityMapper rateEntityMapper;
  private final IRateEntityIdMapper rateEntityIdMapper;
  private final IVideoRepository videoRepository;
  private final IVideoEntityMapper videoEntityMapper;
  private final IVideoEntityIdMapper videoEntityIdMapper;
  private final ITutorshipRepository tutorshipRepository;
  private final ITutorshipEntityMapper tutorshipEntityMapper;
  private final ITutorshipEntityIdMapper tutorshipEntityIdMapper;
  private final ISectionRepository sectionRepository;
  private final ISectionEntityMapper sectionEntityMapper;
  private final ISectionEntityIdMapper sectionEntityIdMapper;
  private final ICourseRepository courseRepository;
  private final ICourseEntityMapper courseEntityMapper;
  private final IInscriptionRepository inscriptionRepository;
  private final IInscriptionEntityMapper inscriptionEntityMapper;
  private final IInscriptionEntityIdMapper inscriptionEntityIdMapper;
  private final IUniversityEntityMapper universityEntityMapper;
  private final IUniversityRepository universityRepository;

  @Bean
  public IPasswordEncoderPort passwordEncoderPort() {
    return new PasswordEncoderAdapter();
  }

  @Bean
  public IUserPersistencePort userPersistence() {
    return new UserJpaAdapter(userRepository, userEntityMapper);
  }

  @Bean
  public IEmailSenderPort emailSenderPort() {
    return new EmailSenderAdapter();
  }

  @Bean
  public IUserServicePort userService() {
    return new UserUseCase(
        userPersistence(), tokenService(), passwordEncoderPort(), emailSenderPort());
  }

  @Bean
  public IRolPersistencePort rolPersistence() {
    return new RolJpaAdapter(rolRepository, rolEntityMapper);
  }

  @Bean
  public IRolServicePort rolService() {
    return new RolUseCase(rolPersistence());
  }

  @Bean
  public ITokenActivationPersistencePort tokenPersistence() {
    return new TokenActivationJpaAdapter(tokenRepository, tokenEntityMapper);
  }

  @Bean
  public ITokenActivationServicePort tokenService() {
    return new TokenActivationUseCase(tokenPersistence());
  }

  @Bean
  public IRatePersistencePort ratePersistencePort() {
    return new RateJpaAdapter(rateRepository, rateEntityMapper, rateEntityIdMapper, courseEntityMapper);
  }

  @Bean
  public IRateServicePort rateServicePort() {
    return new RateUseCase(ratePersistencePort());
  }

  @Bean
  public ICommentPersistencePort commentPersistencePort() {
    return new CommentJpaAdapter(commentRepository, commentEntityMapper, commentEntityIdMapper);
  }

  @Bean
  public ICommentServicePort commentServicePort() {
    return new CommentUseCase(commentPersistencePort());
  }

  @Bean
  public ICategoryPersistencePort categoryPersistencePort() {
    return new CategoryJpaAdapter(categoryRepository, categoryEntityMapper);
  }

  @Bean
  public ICategoryServicePort categoryServicePort() {
    return new CategoryUseCase(categoryPersistencePort());
  }

  @Bean
  public IVideoPersistencePort videoPersistencePort() {
    return new VideoJpaAdapter(videoRepository, videoEntityMapper, videoEntityIdMapper);
  }

  @Bean
  public IVideoServicePort videoServicePort() {
    return new VideoUseCase(videoPersistencePort());
  }

  @Bean
  public ITutorshipPersistencePort tutorshipPersistencePort() {
    return new TutorshipJpaAdapter(
        tutorshipRepository, tutorshipEntityMapper, tutorshipEntityIdMapper, courseEntityMapper);
  }

  @Bean
  public ITutorshipServicePort tutorshipServicePort() {
    return new TutorshipUseCase(tutorshipPersistencePort());
  }

  @Bean
  public ISectionPersistencePort sectionPersistencePort() {
    return new SectionJpaAdapter(sectionRepository, sectionEntityMapper, sectionEntityIdMapper);
  }

  @Bean
  public ISectionServicePort sectionServicePort() {
    return new SectionUseCase(sectionPersistencePort());
  }

  @Bean
  public ICoursePersistencePort coursePersistencePort() {
    return new CourseJpaAdapter(courseRepository, courseEntityMapper, userEntityMapper);
  }

  @Bean
  public ICourseServicePort courseServicePort() {
    return new CourseUseCase(coursePersistencePort(), userPersistence());
  }

  @Bean
  public IInscriptionPersistencePort inscriptionPersistencePort() {
    return new InscriptionJpaAdapter(
        inscriptionRepository,
        inscriptionEntityIdMapper,
        inscriptionEntityMapper,
        userEntityMapper, courseEntityMapper);
  }

  @Bean
  public IInscriptionServicePort inscriptionServicePort() {
    return new InscriptionUseCase(inscriptionPersistencePort());
  }

  @Bean
  public IUniversityPersistencePort universityRepositoryPort() {
    return new UniversityJpaAdapter(universityRepository, universityEntityMapper);
  }

  @Bean
  public IUniversityServicePort universityServicePort() {
    return new UniversityUseCase(universityRepositoryPort());
  }
}
