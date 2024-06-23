package com.paintingscollectors.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/paintings")
public interface PaintingController {

    @GetMapping("/{id}")
    String viewPaintingDetails(@PathVariable String id, Model model);

    @PostMapping("/{id}/favorite")
    String addToFavorites(@PathVariable String id);

    @GetMapping("/{id}/edit")
    String editPainting(@PathVariable String id, Model model);

    @PostMapping("/{id}/edit")
    String updatePainting(@PathVariable String id, @Valid Painting painting, BindingResult result);

    @GetMapping("/{id}/delete")
    String deletePainting(@PathVariable String id);

}
