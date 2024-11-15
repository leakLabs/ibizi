package edu.lab.lab6;

import java.util.*;

public class AccessMatrix {
    private static final int OBJECT_COUNT = 5;
    private final Map<User, Map<Integer, AccessRights>> accessMatrix;
    private final List<User> users;

    public AccessMatrix() {
        accessMatrix = new HashMap<>();
        users = new ArrayList<>();

        // Создаем пользователей
        User admin = new User("Ivan", true);
        User user1 = new User("Sergey", false);
        User user2 = new User("Boris", false);

        users.add(admin);
        users.add(user1);
        users.add(user2);

        // Заполняем матрицу доступа
        initializeAccessMatrix();
    }

    public List<User> getUsers() {
        return users;
    }

    private void initializeAccessMatrix() {
        Random rand = new Random();
        for (User user : users) {
            Map<Integer, AccessRights> userRights = new HashMap<>();
            for (int i = 1; i <= OBJECT_COUNT; i++) {
                if (user.isAdmin) {
                    userRights.put(i, new AccessRights(true, true, true));
                } else {
                    boolean read = rand.nextBoolean();
                    boolean write = rand.nextBoolean();
                    boolean grant = rand.nextBoolean();
                    userRights.put(i, new AccessRights(read, write, grant));
                }
            }
            accessMatrix.put(user, userRights);
        }
    }

    public void displayAccessRights(User user) {
        System.out.println("Перечень прав доступа для пользователя: " + user.name);
        Map<Integer, AccessRights> rights = accessMatrix.get(user);
        for (Map.Entry<Integer, AccessRights> entry : rights.entrySet()) {
            System.out.println("Объект" + entry.getKey() + ": " + entry.getValue());
        }
    }

    public boolean hasAccess(User user, int objectId, String operation) {
        Map<Integer, AccessRights> rights = accessMatrix.get(user);
        AccessRights accessRights = rights.get(objectId);

        return switch (operation) {
            case "read" -> accessRights.read;
            case "write" -> accessRights.write;
            case "grant" -> accessRights.grant;
            default -> false;
        };
    }

    public void grantAccess(User user, int objectId, String targetUser) {
        if (!user.isAdmin) {
            System.out.println("У вас нет прав для передачи прав.");
            return;
        }

        for (User u : users) {
            if (u.name.equals(targetUser)) {
                Map<Integer, AccessRights> rights = accessMatrix.get(u);
                rights.put(objectId, new AccessRights(true, true, true));
                System.out.println("Права успешно переданы пользователю " + targetUser + " на объект " + objectId);
                return;
            }
        }
        System.out.println("Пользователь не найден.");
    }

    public String getAccessMatrixTable() {
        StringBuilder table = new StringBuilder();

        // Заголовок таблицы
        table.append(String.format("%-10s", "User"));
        for (int i = 1; i <= OBJECT_COUNT; i++) {
            table.append(String.format(" Obj%d ", i));
        }
        table.append("\n");

        // Строки для каждого пользователя
        for (User user : users) {
            table.append(String.format("%-10s", user.name));
            Map<Integer, AccessRights> rights = accessMatrix.get(user);

            for (int i = 1; i <= OBJECT_COUNT; i++) {
                AccessRights accessRights = rights.get(i);
                String rightsString = (accessRights.read ? "R" : "") +
                        (accessRights.write ? "W" : "") +
                        (accessRights.grant ? "G" : "");
                table.append(String.format("%-6s", rightsString.isEmpty() ? "-" : rightsString));
            }
            table.append("\n");
        }

        return table.toString();
    }
}