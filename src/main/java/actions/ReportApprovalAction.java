package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import constants.AttributeConst;
import constants.ForwardConst;
import services.EmployeeService;

    /**
     * 従業員に関わる処理を行うActionクラス
     *
     */
    public class ReportApprovalAction extends ActionBase {

        private EmployeeService service;

        /**
         * メソッドを実行する
         */
        @Override
        public void process() throws ServletException, IOException {

            service = new EmployeeService();

            //メソッドを実行
            invoke();

            service.close();
        }

    /**
     * ログイン中の従業員の権限をチェックし、承認者権限がなければエラー画面を表示
     * 0:一般 1:課長 2:部長
     * @throws ServletException
     * @throws IOException
     */
    private boolean checkApproval() throws ServletException, IOException {

        // セッションからログイン中の従業員情報を取得
        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        // 承認者でなければエラー画面を表示
        if (ev.getApprovalFlag() == AttributeConst.ROLE_GENERALS.getIntegerValue()) {
            forward(ForwardConst.FW_ERR_UNKNOWN);
            return false;
        } else {
            return true;
        }
    }

}
