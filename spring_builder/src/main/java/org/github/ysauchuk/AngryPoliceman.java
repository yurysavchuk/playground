package org.github.ysauchuk;

public class AngryPoliceman implements Policeman {

  @InjectByType
  private Recommendator recommendator;

  @Override
  public void makePeopleLeaveRoom() {
    System.out.println("Всех убью! Вон пошли!");
  }
}
