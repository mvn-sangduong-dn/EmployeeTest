package monstarrlab.demo.service.Impl;


import monstarrlab.demo.model.Position;
import monstarrlab.demo.repository.IPositionRepository;
import monstarrlab.demo.service.IPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public Position getPositionById(long id) {
        return iPositionRepository.findById(id).get();
    }
}
