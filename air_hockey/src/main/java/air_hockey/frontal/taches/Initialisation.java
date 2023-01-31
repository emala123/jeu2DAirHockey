package air_hockey.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.services.Window;

public class Initialisation {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Initialisation")

				.contains(subTasks -> {

					afficherFenetre(subTasks);

				});
	}

	private static void afficherFenetre(FrontendTasks subTasks) {

		subTasks.task("afficherFenetre")

				.waitsFor(window())

				.thenExecutes(inputs -> {

					Window window = inputs.get(window());

					window.show();
				});
	}

}
