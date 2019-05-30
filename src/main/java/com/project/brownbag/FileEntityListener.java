package com.project.brownbag;

import static javax.transaction.Transactional.TxType.MANDATORY;

//This class using entitymanager instead of filehistoryrepository

import javax.persistence.EntityManager;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.transaction.Transactional;

import com.project.brownbag.util.Action;
import com.project.brownbag.util.BeanUtil;



public class FileEntityListener {

  @PrePersist
  public void prePersist(DataFile target) {
      perform(target, Action.INSERTED);
  }

  @PreUpdate
  public void preUpdate(DataFile target) {
      perform(target,Action. UPDATED);
  }

  @PreRemove
  public void preRemove(DataFile target) {
      perform(target, Action.DELETED);
  }

  @Transactional(MANDATORY)
  private void perform(DataFile target, Action action) {
      EntityManager entityManager = BeanUtil.getBean(EntityManager.class);
      entityManager.persist(new FileHistory(target, action));
  }

}
