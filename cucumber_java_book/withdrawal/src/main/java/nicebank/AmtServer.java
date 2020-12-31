package nicebank;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.javalite.activejdbc.Base;

public class AmtServer {

  private final Server server;

  public AmtServer(int port, CashSlot cashSlot, Account account) {
    server = new Server(port);

    ServletContextHandler context =
        new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");
    server.setHandler(context);

    context.addServlet(new ServletHolder(new WithdrawalServlet(cashSlot, account)), "/withdraw");
    context.addServlet(new ServletHolder(new AmtServlet()), "/");
  }

  public void start() throws Exception {
    server.start();
    System.out.println("Listening on " + server.getURI());
  }

  public void stop() throws Exception {
    server.stop();
    System.out.println("Server shutdown");
  }

  public static void main(String[] args) throws Exception {
    Base.open(
        "com.mysql.jdbc.Driver",
        "jdbc:mysql://localhost/bank",
        "teller",
        "password"
    );
    new AmtServer(9988, new CashSlot(), new Account()).start();
  }

}
