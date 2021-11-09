package constants;

/**
 * DB関連の項目値を定義するインターフェース
 * ※インターフェースに定義した変数はpubic static final 修飾子がついてるとみなされる
 */
public interface JpaConst {

    // persistence-unit名
    String PERSISTENCE_UNIT_NAME = "daily_report_system";

    // データ取得件数の最大値
    int ROW_PER_PAGE = 15;  // 1ページに表示するレコード数

    // 従業員テーブル
    String TABLE_EMP = "employees"; // テーブル名
    // 従業員テーブルカラム
    String EMP_COL_ID = "id";   // id
    String EMP_COL_CODE = "code";   // 社員番号
    String EMP_COL_NAME = "name";   // 氏名
    String EMP_COL_PASS = "password";   // パスワード
    String EMP_COL_ADMIN_FLG = "admin_flag";    // 管理者権限
    String EMP_COL_APPROVAL_FLG = "approval_flag";   // 承認者権限
    String EMP_COL_CREATED_AT = "created_at";   // 登録日時
    String EMP_COL_UPDATED_AT = "updated_at";   // 更新日時
    String EMP_COL_DELETE_FLG = "delete_flag"; // 削除フラグ
    int ROLE_DIRECTOR = 2;  // 承認権限オン(部長)
    int ROLE_MANAGER = 1;   // 承認権限オン(課長)
    int ROLE_GENERALS = 0;  // 承認権限オフ（一般）
    int ROLE_ADMIN = 1; // 管理者権限オン(管理者)
    int ROLE_GENERAL = 0;   // 管理者権限オフ（一般）
    int EMP_DEL_TRUE = 1;   // 削除フラグオン(削除済み)
    int EMP_DEL_FALSE = 0;  // 削除フラグオフ(現役)
    int APP_FLAG_TRUE = 1;  // 承認フラグオン(承認済み)
    int APP_FLAG_FALSE = 0; // 承認フラグオフ(未承認)

    // 日報テーブル
    String TABLE_REP = "reports";   // テーブル名
    // 日報テーブルカラム
    String REP_COL_ID = "id";   // id
    String REP_COL_EMP = "employee_id"; // 日報を作成した従業員のid
    String REP_COL_REP_DATE = "report_date";    // いつの日程かを示す日付
    String REP_COL_TITLE = "title"; // 日報タイトル
    String REP_COL_CONTENT = "content"; // 日報の内容
    String REP_COL_CREATED_AT = "created_at";   // 登録日時
    String REP_COL_UPDATED_AT = "updated_at";   // 更新日時
    String REP_COL_COMPANY = "company"; // 会社名
    String REP_COL_CLIENT = "client";   // 名前
    String REP_COL_MAIL = "mail";   // メールアドレス
    String REP_COL_TEL = "telephone";  // 電話番号
    String REP_COL_STATUS = "status";    // 商談状況
    String REP_COL_APPROVAL_FLG = "approvals_flag";   // 承認されているかどうか
    // Entity名
    String ENTITY_EMP = "employee"; // 従業員
    String ENTITY_REP = "report";   // 日報
    String ENTITY_CLI = "client";   // 顧客

    // JPQL内パラメータ
    String JPQL_PARM_CODE = "code"; // 社員番号
    String JPQL_PARM_PASSWORD = "password"; // パスワード
    String JPQL_PARM_EMPLOYEE = "employee"; // 従業員

    // NamedQueryのnameとquery
    // 全ての従業員をidの降順に取得
    String Q_EMP_GET_ALL = ENTITY_EMP + ".getAll";  // name
    String Q_EMP_GET_ALL_DEF ="SELECT e FROM Employee AS e ORDER BY e.id DESC"; // query
    // 全ての従業員の件数を取得
    String Q_EMP_COUNT = ENTITY_EMP + ".count";
    String Q_EMP_COUNT_DEF = "SELECT COUNT(e) FROM Employee AS e";
    // 社員番号とハッシュ化済パスワードを条件に未削除の従業員を取得
    String Q_EMP_GET_BY_CODE_AND_PASS = ENTITY_EMP + "getByCodeAndPass";
    String Q_EMP_GET_BY_CODE_AND_PASS_DEF = "SELECT e FROM Employee AS e WHERE e.deleteFlag = 0 AND e.code = :" + JPQL_PARM_CODE + " AND e.password = :" + JPQL_PARM_PASSWORD;
    // 指定した社員番号を保持する従業員の件数を取得
    String Q_EMP_COUNT_RESISTERED_BY_CODE = ENTITY_EMP + ".countRegisteredByCode";
    String Q_EMP_COUNT_RESISTERED_BY_CODE_DEF = "SELECT COUNT(e) FROM Employee AS e WHERE e.code = :" + JPQL_PARM_CODE;
    // 全ての日報をidの降順に取得
    String Q_REP_GET_ALL = ENTITY_REP + ".getALL";
    String Q_REP_GET_ALL_DEF = "SELECT r FROM Report AS r ORDER BY r.id DESC";
    //全ての日報の件数を取得する
    String Q_REP_COUNT = ENTITY_REP + ".count";
    String Q_REP_COUNT_DEF = "SELECT COUNT(r) FROM Report AS r";
    // 指定した従業員が作成した日報を全件idの降順で取得
    String Q_REP_GET_ALL_MINE = ENTITY_REP + "getAllMine";
    String Q_REP_GET_ALL_MINE_DEF = "SELECT r FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE + " ORDER BY r.id DESC";
    // 指定した従業員が作成した日報の件数を取得
    String Q_REP_COUNT_ALL_MINE = ENTITY_REP + ".countAllMine";
    String Q_REP_COUNT_ALL_MINE_DEF = "SELECT COUNT(r) FROM Report AS r WHERE r.employee = :" + JPQL_PARM_EMPLOYEE;
    // 承認されていない日報を取得
    String Q_REP_GET_BY_APPROVAL_FLG = ENTITY_REP + "getByApprovalFlag";
    String Q_REP_GET_BY_APPROVAL_FLG_DEF = "SELECT r FROM Report AS r WHERE r.approvalsFlag = 0";
    // 承認されている日報を取得

}
