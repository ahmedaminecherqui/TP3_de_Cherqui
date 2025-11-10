package ma.emsi.cherqui.tp3_de_cherqui.llm;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;
import ma.emsi.cherqui.tp3_de_cherqui.model.GuideResponse;

import java.io.Serializable;
import java.time.Duration;

/**
 * Gère l'interface avec l'API de Gemini via LangChain4j.
 * De portée @Dependent : l'instance sera supprimée quand le backing bean sera supprimé.
 */
@Dependent
public class LlmClient implements Serializable {

    private GuideTouristique guideTouristique;
    private ChatMemory chatMemory;
    private ChatModel chatModel;

    public LlmClient() {
        // 1. Récupère la clé secrète depuis une variable d'environnement
        String apiKey = System.getenv("GEMINI_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "La clé API Gemini n'est pas définie dans la variable d'environnement GEMINI_API_KEY"
            );
        }

        // 2. Crée le modèle de chat Gemini
        this.chatModel = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .timeout(Duration.ofSeconds(60))
                .build();

        // 3. Crée la mémoire (garde jusqu'à 10 messages)
        this.chatMemory = MessageWindowChatMemory.withMaxMessages(10);

        // 4. Crée l'assistant (service IA)
        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(chatModel)
                .chatMemory(chatMemory)
                .build();
    }

    /**
     * Envoie une question au LLM et retourne la réponse.
     *
     * @param question la question posée par l'utilisateur
     * @return la réponse du LLM
     */
    public GuideResponse poserQuestion(String question,String nbr_endroits) {
        if (question == null || question.isBlank()) {
            throw new IllegalArgumentException("La question ne peut pas être vide");
        }
        // LangChain4j gère automatiquement l'historique via chatMemory
        return guideTouristique.ask(question,nbr_endroits);
    }

    /**
     * Réinitialise la conversation (vide la mémoire).
     */
    public void reinitialiserConversation() {
        this.chatMemory.clear();
    }
}
