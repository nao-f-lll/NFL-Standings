package clasificacion;

class Match {
    private String localTeam;
    private String visitorTeam;
    private int localScore;
    private int visitorScore;

    public Match(String localTeam, String visitorTeam, int localScore, int visitorScore) {
        this.localTeam = localTeam;
        this.visitorTeam = visitorTeam;
        this.localScore = localScore;
        this.visitorScore = visitorScore;
    }

    public String getLocalTeam() {
        return localTeam;
    }

    public String getVisitorTeam() {
        return visitorTeam;
    }

    public int getLocalScore() {
        return localScore;
    }

    public int getVisitorScore() {
        return visitorScore;
    }

    @Override
    public String toString() {
        return localTeam + " " + localScore + " - " + visitorScore + " " + visitorTeam;
    }
}