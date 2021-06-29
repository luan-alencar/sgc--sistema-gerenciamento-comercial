package david.augusto.luan.sgc.service.impl.utils;

public class ConstantsUtil {
    public static final String USUARIO_CPF_EMAIL_DUPLICADO = "Usuario com CPF ja cadastrado.";
    public static final String ERROR_TITLE =  "error.title";

    public static final String REGEX_CPF = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
    public static final String REGEX_PONTO_HIFEN = "[.|-]";

    public static final String FORMATO_CPF = "$1.$2.$3-$4";
    public static final String MASCARA_CPF = "###.###.###-##";
    public static final String CPF_NAO_CADASTRADO = "CPF não cadastrado.";

    public static final String HIFEN = "-";
    public static final String PONTO = ".";

    public static final Integer POSICAO_ZERO = 0;
    public static final Integer POSICAO_TRES = 3;
    public static final Integer POSICAO_SEIS = 6;
    public static final Integer POSICAO_NOVE = 9;
    public static final Integer POSICAO_ONZE = 11;

}
