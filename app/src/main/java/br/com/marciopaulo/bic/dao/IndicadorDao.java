package br.com.marciopaulo.bic.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.marciopaulo.bic.model.Indicador;
import br.com.marciopaulo.bic.model.Item;

/**
 * Created by marci on 07/12/2016.
 */

public class IndicadorDao {

    private SQLiteDatabase db;

    public static String createTable(){
        return  "CREATE TABLE "+ Indicador.NOME_TABELA +" ("
                + Indicador.COLUNA_ID +" INTEGER , "
                + Indicador.COLUNA_TEMA_ID + " INTEGER NULL, "
                + Indicador.COLUNA_NOME + " TEXT); ";
    }

    public static String Carga(){

        String sql="INSERT INTO indicador (_id, nome, temaID ) VALUES (6, 'População total', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (7, 'População masculina', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (8, 'População feminina', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (9, 'Percentual da população masculina', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (10, 'Percentual da população feminina', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (11, 'Pessoas com idade de 0 a 4 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (12, 'Pessoas com idade de 5 a 9 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (13, 'Pessoas com idade de 10 a 14 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (14, 'Pessoas com idade de 15 a 19 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (15, 'Pessoas com idade de 20 a 29 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (16, 'Pessoas com idade de 30 a 39 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (17, 'Pessoas com idade de 40 a 49 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (18, 'Pessoas com idade de 50 a 59 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (19, 'Pessoas com idade de 60 a 69 anos', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (20, 'Pessoas com 70 anos ou mais', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (21, 'Pessoas de raça/ cor - branca', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (22, 'Pessoas de raça/ cor - preta', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (23, 'Pessoas de raça/ cor - amarela', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (24, 'Pessoas de raça/ cor - parda', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (25, 'Pessoas de raça/ cor - indígena', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (26, 'Pessoas de raça/ cor - sem declaração', 7);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (27, 'Imigrantes total (não nascidos)', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (28, 'Imigrante intraestadual', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (29, 'Imigrante interestadual', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (30, 'Estrangeiro', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (31, 'Percentual de imigrantes recentes (tempo de residência igual ou menor que 9 anos)', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (32, 'Percentual de imigrantes antigos (tempo de residência igual ou maior que 10 anos)', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (33, 'Saldo migratório intrametropolitano (data fixa)', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (34, 'Saldo migratório intraestadual (data fixa)', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (35, 'Saldo migratório interestadual (data fixa)', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (36, 'Saldo migratório total (data fixa)', 8);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (37, 'Frequência por religião - Católica', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (38, 'Frequência por religião - Evangélico Pentecostais', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (39, 'Frequência por religião - Sem religião, agnósticos e ateus', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (40, 'Frequência por religião - Evangélico Neopentecostais', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (41, 'Frequência por religião - Espiritualista ou Espírita', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (42, 'Frequência por religião - Protestantes Históricas', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (43, 'Frequência por religião - Religiosidade cristã não determinada', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (44, 'Frequência por religião - Cristãs Restauracionistas', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (45, 'Frequência por religião - Outras e Não Determinada', 9);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (46, 'Média de alunos por turma na educação infantil privada', 10);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (47, 'Média de alunos por turma na educação infantil pública', 10);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (48, 'Percentual de crianças de 0 a 3 anos frequentando creches privadas', 10);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (49, 'Percentual de crianças de 0 a 3 anos frequentando creches públicas', 10);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (50, 'Percentual de crianças de 4 a 5 anos frequentando pré-escolas privadas', 10);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (51, 'Percentual de crianças de 4 a 5 anos frequentando pré-escolas públicas', 10);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (52, 'Média de alunos por turma no ensino fundamental I privado', 11);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (53, 'Média de alunos por turma no ensino fundamental I público', 11);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (54, 'Taxa de distorção idade-série/ano escolas privadas (ensino fundamental I)', 11);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (55, 'Taxa de distorção idade-série/ano escolas públicas (ensino fundamental I)', 11);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (56, 'IDEB ensino fundamental 4ª série/ 5º ano', 11);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (58, 'Média de alunos por turma no ensino fundamental II privado', 12);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (59, 'Média de alunos por turma no ensino fundamental II público', 12);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (60, 'Taxa de distorção idade-série/ano escolas privadas (ensino fundamental II)', 12);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (61, 'Taxa de distorção idade-série/ano escolas públicas (ensino fundamental II)', 12);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (62, 'IDEB ensino fundamental 8ª série/ 9º ano', 12);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (63, 'Média de alunos por turma no ensino médio privado', 13);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (65, 'Média de alunos por turma no ensino médio público', 13);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (66, 'Taxa de distorção idade-série/ano escolas privadas (ensino médio)', 13);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (67, 'Taxa de distorção idade-série/ano escolas públicas (ensino médio)', 13);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (68, 'Percentual de pessoas com ensino superior completo com idade de 25 anos ou mais', 14);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (69, 'Pessoas Frequentando EJA etapa ensino fundamental', 15);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (70, 'Pessoas Frequentando EJA etapa ensino médio', 15);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (71, 'Taxa de analfabetismo (pessoas com 10 anos ou mais de idade)', 15);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (72, 'Total de leitos de internação estaduais', 16);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (73, 'Total de leitos de internação municipais', 16);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (74, 'Total de leitos de internação particulares', 16);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (75, 'Total de leitos de internação', 16);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (76, 'Expectativa de vida ao nascer', 17);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (77, 'Taxa de mortalidade infantil', 17);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (78, 'Taxa bruta de natalidade', 17);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (79, 'Proporção de nascidos vivos de mães com 7 ou mais consultas pré-natais', 17);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (80, 'Taxa de mortalidade geral', 17);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (81, 'Taxa de mortalidade antes dos 60 anos ', 17);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (82, 'Proporção de internações por causas sensíveis à atenção básica', 18);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (83, 'Quantidade de agentes comunitários de saúde implantados (valor referente a dezembro)', 19);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (84, 'Percentual de cobertura populacional estimada por agentes comunitários de saúde (valor referente a dezembro)', 19);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (85, 'Quantidade de equipes de estratégia da saúde da família implantadas (valor referente a dezembro)', 19);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (86, 'Percentual de cobertura populacional das equipes de estratégia da saúde da família (valor referente a dezembro)', 19);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (87, 'Médicos atuando em estabelecimentos locais (setor privado)', 19);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (88, 'Médicos atuando em estabelecimentos locais (setor público)', 19);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (89, 'Médicos por mil habitantes na cidade (total)', 19);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (90, 'Taxa de desemprego aberto', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (91, 'Taxa de assalariamento formal', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (92, 'Taxa de assalariamento informal', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (93, 'Rendimento nominal total médio dos ocupados', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (94, 'Estabelecimentos por grande setor - Indústria', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (95, 'Estabelecimentos por grande setor - Construção Civil', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (96, 'Estabelecimentos por grande setor - Comércio', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (97, 'Estabelecimentos por grande setor - Serviços', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (98, 'Estabelecimentos por grande setor - Agropecuária', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (99, 'Estabelecimentos nos grandes setores da economia que declaram RAIS ', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (100, 'Trabalhadores por grande setor do estabelecimento empregador - Indústria', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (101, 'Trabalhadores por grande setor do estabelecimento empregador - Construção Civil', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (102, 'Trabalhadores por grande setor do estabelecimento empregador - Comércio', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (103, 'Trabalhadores por grande setor do estabelecimento empregador - Serviços', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (104, 'Trabalhadores por grande setor do estabelecimento empregador - Agropecuária', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (105, 'Trabalhadores nos grandes setores da economia declarados na RAIS', 20);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (106, 'Produto interno bruto a preços correntes', 21);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (107, 'Valor adicionado bruto, a preços correntes, da indústria', 21);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (108, 'Valor adicionado bruto, a preços correntes, da administração, saúde e educação públicas e seguridade social', 21);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (109, 'Valor adicionado bruto, a preços correntes, dos serviços, exceto administração, saúde e educação públicas e seguridade social', 21);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (110, 'Valor adicionado bruto, a preços correntes, da agropecuária', 21);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (111, 'Impostos, líquidos de subsídios, sobre produtos, a preços correntes', 21);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (112, 'IDH geral', 27);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (113, 'Componente IDH - Educação', 27);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (114, 'Componente IDH - Longevidade', 27);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (115, 'Componente IDH - Renda', 27);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (116, 'Índice de Gini da renda domiciliar per capita', 28);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (117, 'Nº de domicílios com renda per capita de 0 (inclusive) a 1/2 salário mínimo (exclusive)', 29);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (119, 'Total de domicílios ', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (120, 'Percentual de domicílios abastecido por rede de distribuição ou poço', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (121, 'Percentual de domicílios com acesso à rede de esgoto ou com fossa séptica', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (122, 'Percentual de domicílios com coleta de lixo', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (123, 'Percentual de domicílios com banheiro de uso exclusivo da residência', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (124, 'Percentual de domicílios com acesso à rede de energia elétrica', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (125, 'Percentual de domicílios com microcomputador', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (126, 'Percentual de domicílios com microcomputador com acesso à internet', 30);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (127, 'Taxa de homicídio doloso', 31);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (128, 'Taxa de furto ou roubo geral, exceto veículos', 31);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (129, 'Taxa de furto ou roubo de veículos', 31);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (130, 'Monóxido de carbono', 23);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (131, 'Particulas inaláveis (MP10)', 23);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (132, 'Dióxido de enxofre', 1);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (133, 'Índice de qualidade dos aterros', 25);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (134, 'ICTEM', 26);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (138, 'Domicílios improvisados', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (139, 'Domicílios alugados', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (140, 'Domicílios sem banheiro', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (141, 'Pessoas analfabetas com 10 anos ou mais de idade', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (142, 'Pessoas com idade de 0 a 3 anos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (143, 'Pessoas com idade de 4 a 5 anos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (144, 'Pessoas com idade de 6 a 10 anos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (145, 'Pessoas com idade de 11 a 14 anos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (146, 'Pessoas com idade de 15 a 17 anos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (147, 'Pessoas com idade de 18 a 21 anos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (148, 'Pessoas com idade de 22 a 29 anos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (154, 'Rendimento médio dos responsáveis', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (155, 'Média de moradores nos domicílios', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (159, 'Pessoas de raça/ cor - outra cor', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (161, 'Domicílios SEM rendimento no mês de referência', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (162, 'Domicílios com rendimento mensal domiciliar por pessoa maior que 0 e até 1 salário mínimo', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (163, 'Domicílios com rendimento mensal domiciliar por pessoa maior que 1 e até 3 salários mínimos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (164, 'Domicílios com rendimento mensal domiciliar por pessoa maior que 3 e até 5 salários mínimos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (165, 'Domicílios com rendimento mensal domiciliar por pessoa maior que 5 e até 10 salários mínimos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (166, 'Domicílios com rendimento mensal domiciliar por pessoa maior que 10 salários mínimos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (167, 'Domicílios em área com iluminação pública', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (168, 'Domicílios em área pavimentada', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (169, 'Domicílios em área arborizada', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (170, 'Domicílios em área com esgoto a céu aberto', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (171, 'Domicílios em área com lixo acumulado nas vias', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (172, 'Domicílios com rede geral de distribuição de água', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (173, 'Pessoas que estudam em escola pública', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (174, 'Pessoas que estudam em escola particular', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (175, 'Pessoas que não estudam, mas que já frequentaram escola', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (176, 'Pessoas que nunca frequentaram escola', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (177, 'Total de ocupados', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (178, 'Ocupados empregados com carteira de trabalho assinada', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (179, 'Ocupados  militar do exército, marinha, aeronáutica, policia militar ou corpo de bombeiros', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (180, 'Ocupados empregados pelo regime jurídico dos funcionários públicos', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (181, 'Ocupados empregados sem carteira de trabalho assinada', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (182, 'Ocupados por conta própria', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (201, 'Ocupados empregadores', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (219, 'Ocupados não remunerados', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (220, 'Renda média familiar total mensal', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (221, 'Tamanho médio da família', NULL);";
        sql+="INSERT INTO indicador (_id, nome, temaID ) VALUES (222, 'Média de idade', NULL);";

        return  sql;
    }



    public List<Indicador> Listar(ArrayList<Integer> temasID) {
        List<Indicador> indicadores = new ArrayList<>();

        Cursor cursor;
        String[] campos = {Indicador.COLUNA_ID, Indicador.COLUNA_NOME, Indicador.COLUNA_TEMA_ID};
        String where = Indicador.COLUNA_TEMA_ID + " IN (" + android.text.TextUtils.join(",",temasID)  +")";
        String orderBy= Indicador.COLUNA_NOME + " ASC";

        db = DatabaseManager.getInstance().openDatabase(true);

        cursor = db.query(Indicador.NOME_TABELA, campos, where, null, null, null, orderBy, null);

        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    Indicador indicador = new Indicador();
                    indicador.setId(cursor.getInt(cursor.getColumnIndex(Indicador.COLUNA_ID)));
                    indicador.setNome(cursor.getString(cursor.getColumnIndex(Indicador.COLUNA_NOME)));

                    if(!cursor.isNull(cursor.getColumnIndex(Indicador.COLUNA_TEMA_ID))){
                        indicador.setTemaID(cursor.getInt(cursor.getColumnIndex(Indicador.COLUNA_TEMA_ID)));
                    }


                    indicadores.add(indicador);


                } while(cursor.moveToNext());
            }
        }
        DatabaseManager.getInstance().closeDatabase();
        return indicadores;
    }
}
