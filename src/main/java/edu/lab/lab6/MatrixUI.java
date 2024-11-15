package edu.lab.lab6;

import java.util.Scanner;

public class MatrixUI {
    public static void run() {
        AccessMatrix matrix = new AccessMatrix();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите имя пользователя для входа: ");
            String username = scanner.nextLine();

            // Поиск пользователя
            User currentUser = matrix.getUsers().stream()
                    .filter(user -> user.name.equals(username))
                    .findFirst()
                    .orElse(null);

            if (currentUser == null) {
                System.out.println("Пользователь не найден.");
                return;
            }

            System.out.println("Идентификация прошла успешно, добро пожаловать в систему, " + currentUser.name);
            matrix.displayAccessRights(currentUser);

            while (true) {
                System.out.print("Жду ваших указаний > ");
                String command = scanner.nextLine();

                if (command.equals("quit")) {
                    System.out.println("Работа пользователя " + currentUser.name + " завершена. До свидания.");
                    break;
                }

                int objectId = 0;
                if(!command.equals("get table")) {
                    System.out.print("Над каким объектом производить операцию? ");
                    objectId = Integer.parseInt(scanner.nextLine());
                }

                switch (command) {
                    case "get table":
                        if (currentUser.isAdmin) {
                            System.out.println(matrix.getAccessMatrixTable());
                        } else {
                            System.out.println("Отказ в выполнении операции. Операция может быть выполнена только администратором");
                        }
                        break;
                    case "read":
                    case "write":
                        if (matrix.hasAccess(currentUser, objectId, command)) {
                            System.out.println("Операция прошла успешно.");
                        } else {
                            System.out.println("Отказ в выполнении операции. У вас нет прав для её осуществления.");
                        }
                        break;

                    case "grant":
                        System.out.print("Кому передать права? ");
                        String targetUser = scanner.nextLine();
                        matrix.grantAccess(currentUser, objectId, targetUser);
                        break;

                    default:
                        System.out.println("Неизвестная команда.");
                        break;
                }
            }
        }
    }
}
