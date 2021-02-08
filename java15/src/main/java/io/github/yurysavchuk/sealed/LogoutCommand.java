package io.github.yurysavchuk.sealed;

// another sealed class
// sealed class must have subclasses
public sealed class LogoutCommand implements Command permits LogoutAndDeleteCachedCommand {

}
