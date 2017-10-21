use library;

-- 代码类型表

drop table if exists L_DAR_CodeType;

create table library.L_DAR_CodeType
(
    C_ID                 varchar(50)                          NOT NULL     comment '代码类型编号',
    C_Name               varchar(300)                         NOT NULL     comment '代码类型名称',
    N_IsValid              varchar(32)         default '1'          NOT NULL     comment '是否有效',
    N_IsMaintain            varchar(32)         default '2'          NOT NULL     comment '是否可维护',
constraint PK_Aty_CodeType primary key( C_ID )
) comment = '代码类型表' ;


use library;

-- 代码表

drop table if exists L_DAR_Code;

create table library.L_DAR_Code
(
    C_PID                varchar(50)     default '0'          NOT NULL     comment '代码类型编号',
    C_Code               varchar(50)                          NOT NULL     comment '代码',
    C_Name               varchar(300)                         NOT NULL     comment '代码名称',
    N_IsMaintain                varchar(32)       default '2'          NOT NULL     comment '可否维护',
    C_LevelInfo          varchar(300)                         NULL         comment '分级信息',
    N_IsValid              varchar(32)          default '1'          NOT NULL     comment '是否有效',
    N_Order              varchar(32)        default '1'          NOT NULL     comment '显示顺序',
    C_Dmjp               varchar(300)                         NULL         comment '代码简拼',
constraint PK_Aty_Code primary key( C_PID,C_Code )
) comment = '代码表' ;


use library;

-- Books书表

drop table if exists L_DAR_Books;

create table library.L_DAR_Books
(
    C_ID                          varchar(32)                              NOT NULL     comment '主键',
    C_BOOKID                      varchar(300)                          NULL     comment '书编码',
    C_BOOKNAME                    varchar(300)                          NULL     comment '书名称',
    C_AUTHOR                      varchar(300)                          NULL     comment '作者',
    C_EDITOR                      varchar(300)                          NULL     comment '编辑者',
    C_TRANSLATOR                  varchar(300)                          NULL     comment '翻译者',
    C_PUBLISHER                   varchar(300)                          NULL     comment '出版社',
    D_PUBLICATIONYEAR             date                                  NULL         comment '出版年',
    N_VERSION                     int(2)                                NULL         comment '版本',
    N_PRINTTIMES                  int(2)                                NULL         comment '第几次印刷',
    N_PRINTNUMBER                 int(10)                               NULL         comment '印刷数',
    N_PRICE                       double(6,2)                           NULL     comment '价格',
    C_CATEGORY                    varchar(300)                          NULL     comment '分类',
    C_DESCRIPTION                 varchar(600)                          NULL         comment '描述'

) comment = 'Books书表' ;


use library;

-- Users用户表

drop table if exists L_DAR_Users;

create table library.L_DAR_Users
(

    C_ID                          char(30)                             NOT NULL      comment '主键',
    C_USERNAME                    varchar(300)                         NOT NULL      comment '用户名',
    C_PASSWORD                    varchar(300)                         NOT NULL      comment '密码',
    C_INDEX                       varchar(300)                         NOT NULL      comment '标识'

) comment = 'Users用户表' ;
