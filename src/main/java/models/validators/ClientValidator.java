package models.validators;

import java.util.ArrayList;
import java.util.List;

import constants.MessageConst;
import models.Client;
import services.ClientService;

/**
 * 顧客インスタンスに設定されている値のバリデーションを行うクラス
 *
 */
public class ClientValidator {
    /**
     * 各項目についてバリデーションを行う
     * @param service
     * @param cl Clientのインスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(
            ClientService service, Client cl) {
        List<String> errors = new ArrayList<String>();

        // 会社名のチェック
        String companyError = validateCompany(cl.getCompany());
        if (!companyError.equals("")) {
            errors.add(companyError);
        }

        // 氏名のチェック
        String nameError = validateName(cl.getName());
        if (!nameError.equals("")) {
            errors.add(nameError);
        }

        // メールアドレスのチェック
        String mailError = validateMail(cl.getMail());
        if (!mailError.equals("")) {
            errors.add(mailError);
        }

        // 電話番号のチェック
        String telephoneError = validateTel(cl.getTelephone());
        if (!telephoneError.equals("")) {
            errors.add(telephoneError);
        }
        return errors;
    }

    /**
     * 会社名に入力値があるかチェックし、なければエラーメッセージを返す
     * @param company 会社名
     * @return エラーメッセージ
     */
    private static String validateCompany(String company) {
        if (company == null || company.equals("")) {
            return MessageConst.C_NOCOMPANY.getMessage();
        }
        // 入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 氏名に入力値があるかチェックし、なければエラーメッセージを返す
     * @param name 氏名
     * @return エラーメッセージ
     */
    private static String validateName(String name) {
        if (name == null || name.equals("")) {
            return MessageConst.C_NONAME.getMessage();
        }
        // 入力値がある場合は空文字を返却
        return "";
    }

    /**
     * メールアドレスに入力値があるかチェックし、なければエラーメッセージを返す
     * @param mail メールアドレス
     * @return エラーメッセージ
     */
    private static String validateMail(String mail) {
        if (mail == null || mail.equals("")) {
            return MessageConst.C_NOMAIL.getMessage();
        }
        // 入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 電話番号に入力値があるかチェックし、なければエラーメッセージを返す
     * @param num 電話番号
     * @return エラーメッセージ
     */
    private static String validateTel(String telephone) {
        if (telephone == null || telephone.equals("")) {
            return MessageConst.C_NOTEL.getMessage();
        }
        // 入力値がある場合は空文字を返却
        return "";
    }
}
