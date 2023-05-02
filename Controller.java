public class Controller {

    public void run() throws Exception {
        ViewCommands com = ViewCommands.NONE;
        Check check = new Check();
        ViewUser view = new ViewUser();
        FileOperation fileoper = new FileOperation();

        while (true) {
            String command = view.prompt("Здравствуйте! Выберите действие (C - create, E - exit): ");
            try {
                com = ViewCommands.valueOf(command);
            } catch (IllegalArgumentException e) {
                System.out.println("Такой команды не существует");
            }
            if (com == ViewCommands.E)
                return;
            if (com == ViewCommands.C) {
                String userInfo = view.prompt(
                        "Введите следующие данные через пробел:\nФамилия\nИмя\nОтчество\nДата рождения(dd.mm.yyyy)\nТелефон\nПол(f/m)\n");
                check.CheckLength(userInfo);
                check.CheckDateFormat(userInfo);
                check.CheckTelefonisNumeric(userInfo);
                check.CheckSex(userInfo);
                fileoper.saveFile(userInfo);
            }
        }
    }

}
