public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(encryption("Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, " +
                "црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв " +
                "бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд " +
                "гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх " +
                "мъбдчъмъжадшд югщючющиивх. Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, " +
                "здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. Ю " +
                "зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя " +
                "чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад " +
                "чжъви шхёвдгюмгдви. Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд " +
                "зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя " +
                "щиню. Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу."));
    }

    public static String encryption(String text) {
        String res = "";
        int step = 1;
        char[] textChar = text.toCharArray();
        char[] arr_ru = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        char[] arr_RU = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
                'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
                'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};

        for (int alphabet = 0; alphabet < 33; alphabet++) {
            for (int i = 0; i < textChar.length; i++) {
                int index = 0;
                boolean isNOTLetter = Character.isWhitespace(textChar[i]);
                if (!isNOTLetter) {
                    if (Character.isLowerCase(textChar[i])) {
                        while (textChar[i] != arr_ru[index]) {
                            index++;
                        }
                        index += step;
                        if (index > 32) {
                            index -= 33;
                        }
                        textChar[i] = arr_ru[index];
                    } else if (Character.isUpperCase(textChar[i])) {
                        while (textChar[i] != arr_RU[index]) {
                            index++;
                        }
                        index += step;
                        if (index > 32) {
                            index -= 33;
                        }
                        textChar[i] = arr_RU[index];
                    }
                }
            }
            for (char c : textChar) {
                res += c;
            }
        }
        return res;
    }
}