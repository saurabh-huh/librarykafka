package com.speingboot.notificationService.Repository;

import com.speingboot.notificationService.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MemberRepository extends MongoRepository<Member, UUID> {
}
