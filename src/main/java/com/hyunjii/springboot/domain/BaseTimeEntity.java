package com.hyunjii.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 상속 시 필드들도 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    // Entity 생성 시 생성시간 자동 저장
    @CreatedDate
    private LocalDateTime createDate;

    // Entity 변경 시 변경 시간 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
