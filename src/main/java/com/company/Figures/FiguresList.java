package com.company.Figures;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

@JsonAutoDetect
@NoArgsConstructor
public class FiguresList implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    ArrayList<Figure> figures;

    public FiguresList(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public void setFigures(ArrayList<Figure> figures) {
        this.figures = figures;
    }

    public String toString() {
        return "Figures% " + this.getFigures();
    }
}
