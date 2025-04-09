package iuh.fit.se.designs.tests;

import iuh.fit.se.designs.ProxyPattern.CommandExecutor;
import iuh.fit.se.designs.ProxyPattern.CommandExecutorProxy;

public class ProxyPatternTest {
	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::" + e.getMessage());
		}
	}
}
