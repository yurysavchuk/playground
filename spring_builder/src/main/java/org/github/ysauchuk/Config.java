package org.github.ysauchuk;

public interface Config {

  <T> Class<? extends T> getImplClass(Class<T> ifc);

  org.reflections.Reflections getScanner();
}
