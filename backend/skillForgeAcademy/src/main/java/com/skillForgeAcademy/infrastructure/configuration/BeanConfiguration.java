package com.skillForgeAcademy.infrastructure.configuration;

import com.skillForgeAcademy.domain.api.ICategoryServicePort;
import com.skillForgeAcademy.domain.api.ICommentServicePort;
import com.skillForgeAcademy.domain.api.ICourseServicePort;
import com.skillForgeAcademy.domain.api.IInscriptionServicePort;
import com.skillForgeAcademy.domain.api.IRateServicePort;
import com.skillForgeAcademy.domain.api.IRolServicePort;
import com.skillForgeAcademy.domain.api.ISectionServicePort;
import com.skillForgeAcademy.domain.api.ITokenServicePort;
import com.skillForgeAcademy.domain.api.ITutorshipServicePort;
import com.skillForgeAcademy.domain.api.IUserServicePort;
import com.skillForgeAcademy.domain.api.IVideoServicePort;
import com.skillForgeAcademy.domain.spi.broker.IEmailSenderPort;
import com.skillForgeAcademy.domain.spi.passwordencoder.IPasswordEncoderPort;
import com.skillForgeAcademy.domain.spi.persistence.ICategoryPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.ICommentPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.ICoursePersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.IInscriptionPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.IRatePersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.IRolPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.ISectionPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.ITokenPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.ITutorshipPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.IUserPersistencePort;
import com.skillForgeAcademy.domain.spi.persistence.IVideoPersistencePort;
import com.skillForgeAcademy.domain.usecase.CategoryUseCase;
import com.skillForgeAcademy.domain.usecase.CommentUseCase;
import com.skillForgeAcademy.domain.usecase.CourseUseCase;
import com.skillForgeAcademy.domain.usecase.InscriptionUseCase;
import com.skillForgeAcademy.domain.usecase.RateUseCase;
import com.skillForgeAcademy.domain.usecase.RolUseCase;
import com.skillForgeAcademy.domain.usecase.SectionUseCase;
import com.skillForgeAcademy.domain.usecase.TokenUseCase;
import com.skillForgeAcademy.domain.usecase.TutorshipUseCase;
import com.skillForgeAcademy.domain.usecase.UserUseCase;
import com.skillForgeAcademy.domain.usecase.VideoUseCase;
import com.skillForgeAcademy.infrastructure.output.broker.adapter.EmailSenderAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.CategoryJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.CommentJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.CourseJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.InscriptionJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.RateJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.RolJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.SectionJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.TokenJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.TutorshipJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.UserJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.adapter.VideoJpaAdapter;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICategoryEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICommentEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICommentEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ICourseEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IInscriptionEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IInscriptionEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRateEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRateEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IRolEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ISectionEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ISectionEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITokenEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITutorshipEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.ITutorshipEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IUserEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IVideoEntityIdMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.mapper.IVideoEntityMapper;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICategoryRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICommentRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ICourseRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IInscriptionRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IRateRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IRolRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ISectionRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITokenRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.ITutorshipRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IUserRepository;
import com.skillForgeAcademy.infrastructure.output.jpa.repository.IVideoRepository;
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
  private final ITokenRepository tokenRepository;
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
  public ITokenPersistencePort tokenPersistence() {
    return new TokenJpaAdapter(tokenRepository, tokenEntityMapper);
  }

  @Bean
  public ITokenServicePort tokenService() {
    return new TokenUseCase(tokenPersistence());
  }

  @Bean
  public IRatePersistencePort ratePersistencePort() {
    return new RateJpaAdapter(rateRepository, rateEntityMapper, rateEntityIdMapper);
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
        userEntityMapper);
  }

  @Bean
  public IInscriptionServicePort inscriptionServicePort() {
    return new InscriptionUseCase(inscriptionPersistencePort());
  }
}
