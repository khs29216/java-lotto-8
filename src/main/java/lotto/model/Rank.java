package lotto.model;

public enum Rank {
    FIRST_PLACE(1, 6, false, 2_000_000_000),
    SECOND_PLACE(2, 5, true, 30_000_000),
    THIRD_PLACE(3, 5, false, 1_500_000),
    FOURTH_PLACE(4, 4, false, 50_000),
    FIFTH_PLACE(5, 3, false, 5_000),
    MISS(0, 0, false, 0);

    private static final int BONUS_CHECK_MATCH_COUNT = 5;

    private final int rank;
    private final int matchCount;
    private final boolean bonusMatched;
    private final int prize;

    Rank(int rank, int matchCount, boolean bonusMatched, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean bonusMatched) {
        for (Rank rank : values()) {
            if (rank.matchRank(matchCount, bonusMatched)) {
                return rank;
            }
        }
        return MISS;
    }

    private boolean matchRank(int matchCount, boolean bonusMatched) {
        return this.matchCount == matchCount && checkBonusMatched(matchCount, bonusMatched);
    }

    private boolean checkBonusMatched(int matchCount, boolean bonusMatched) {
        return matchCount != BONUS_CHECK_MATCH_COUNT || this.bonusMatched == bonusMatched;
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
