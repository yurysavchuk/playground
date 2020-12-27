package org.github.ysauchuk;

@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

  @InjectProperty("wisky")
  private String alcohol;

  public RecommendatorImpl() {
    System.out.println("recommendator was created");
  }

  @Override
  public void recommend() {
    System.out.println("to protect from COVID-2019, drink " + alcohol);
  }

}
