package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.ReportView;
import constants.MessageConst;

/**
 * 日報インスタンスに設定されている値のバリデーションを行うクラス
 */
public class ReportValidator {

    /**
     * 日報インスタンスの各項目についてバリデーションを行う
     * @param rv 日報インスタンス
     * @return エラーのリスト
     */
    public static List<String> validate(ReportView rv) {
        List<String> errors = new ArrayList<String>();

        // タイトルのチェック
        String titleError = validateTitle(rv.getTitle());
        if (!titleError.equals("")) {
            errors.add(titleError);
        }

        // 内容のチェック
        String contentError = validateContent(rv.getContent());
        if (!contentError.equals("")) {
            errors.add(contentError);
        }

        // 取引先企業のチェック
        String companyError = validateCompany(rv.getCompany());
        if (!companyError.equals("")) {
            errors.add(companyError);
        }

        // 取引先相手のチェック
        String clientError = validateClient(rv.getClient());
        if (!clientError.equals("")) {
            errors.add(clientError);
        }

        // メールアドレスのチェック
        String mailError = validateMail(rv.getMail());
        if (!mailError.equals("")) {
            errors.add(mailError);
        }

        // 電話番号のチェック
        String telephoneError = validateTelephone(rv.getTelephone());
        if (!telephoneError.equals("")) {
            errors.add(telephoneError);
        }

        return errors;
    }

    /**
     * タイトルに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param title タイトル
     * @return エラーメッセージ
     */
    private static String validateTitle(String title) {
        if (title == null || title.equals("")) {
            return MessageConst.E_NOTITLE.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 内容に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param content 内容
     * @return エラーメッセージ
     */
    private static String validateContent(String content) {
        if (content == null || content.equals("")) {
            return MessageConst.E_NOCONTENT.getMessage();
        }

        // 入力値がある場合は空文字を返却
        return "";
    }

    /**
     * 取引先企業に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param company 取引先企業
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
      * 取引先相手に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
      * @param company 取引先相手
      * @return エラーメッセージ
      */
      private static String validateClient(String client) {
         if (client == null || client.equals("")) {
             return MessageConst.C_NOCLIENT.getMessage();
         }

         // 入力値がある場合は空文字を返却
         return "";
     }

     /**
      * メールアドレスに入力値があるかをチェックし、入力値がなければエラーメッセージを返却
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
      * 電話番号に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
      * @param telephone 電話番号
      * @return エラーメッセージ
      */
      private static String validateTelephone(String telephone) {
          if (telephone == null || telephone.equals("")) {
              return MessageConst.C_NOTELEPHONE.getMessage();
          }

          // 入力値がある場合は空文字を返却
          return "";
      }
}
